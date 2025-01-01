package org.pancho.controller;

import org.pancho.model.*;
import org.pancho.model.enums.LanguageEnum;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Persistance {
    private final String USERS_FILE = "users.csv";
    private final String PETS_FILE = "pets.csv";
    private final String CARES_FILE = "cares.csv";

    private static Persistance instance;

    // Private constructor
    private Persistance() {}

    // Method to get the singleton instance
    public static Persistance getInstance() {
        if (instance == null) {
            instance = new Persistance();
        }
        return instance;
    }

    public void saveData() {
        createBackup();

        UserController userController = UserController.getUserController();
        PetController petController = PetController.getPetController();
        CareController careController = CareController.getCareController();

        try (FileWriter userWriter = new FileWriter(USERS_FILE, false);
             FileWriter petWriter = new FileWriter(PETS_FILE, false);
             FileWriter careWriter = new FileWriter(CARES_FILE, false)) {

            for (User user : userController.getUserList()) {
                userWriter.write(userController.userToString(user) + "\n");
            }

            for (Pet pet : petController.getPetList()) {
                petWriter.write(petController.petToString(pet) + "\n");
            }

            for (Care care : careController.getCareList()) {
                careWriter.write(careController.careToString(care) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {

        UserController userController = UserController.getUserController();
        PetController petController = PetController.getPetController();
        CareController careController = CareController.getCareController();

        try {

            restoreIfEmptyOrNonExistent(USERS_FILE);
            restoreIfEmptyOrNonExistent(PETS_FILE);
            restoreIfEmptyOrNonExistent(CARES_FILE);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE));
             BufferedReader petReader = new BufferedReader(new FileReader(PETS_FILE));
             BufferedReader careReader = new BufferedReader(new FileReader(CARES_FILE))) {

            String line;
            while ((line = userReader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 13) {
                    if (data[7].equals("null")) {
                        userController.createOwner(data[4], data[5], LanguageEnum.valueOf(data[6]), data[1]);
                    }else{
                        userController.createCaretaker(data[4], data[5], data[7], Double.parseDouble(data[9]), Double.parseDouble(data[10]), LanguageEnum.valueOf(data[6]), data[1]);
                    }
                }
            }

            while ((line = petReader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 7) {
                    petController.registerPet(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5], findOwner(data[6]));
                }
            }

            while ((line = careReader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 8) {
                    careController.createCare(new SimpleDateFormat("dd/MM/yyyy").parse(data[1]), new SimpleDateFormat("dd/MM/yyyy").parse(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[5]), findPet(data[7]));
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void restoreIfEmptyOrNonExistent(String fileName) throws IOException {
        File originalFile = new File(fileName);
        File backupFile = new File(fileName + ".bak");

        if (!originalFile.exists() || originalFile.length() == 0) {
            if (backupFile.exists() && backupFile.length() > 0) {
                Files.copy(Paths.get(fileName + ".bak"), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            } else {
                throw new IOException("Both original and backup files for " + fileName + " are missing or empty.");
            }
        }
    }

    public void createBackup() {
        try {
            // Create backups
            Files.copy(Paths.get(USERS_FILE), Paths.get(USERS_FILE + ".bak"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(PETS_FILE), Paths.get(PETS_FILE + ".bak"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(CARES_FILE), Paths.get(CARES_FILE + ".bak"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error creating backup files: " + e.getMessage());
        }
    }

    private Owner findOwner(String email) {
        UserController userController = UserController.getUserController();
        return (Owner) userController.getUser(email);
    }


    private Pet findPet(String riac) {
        PetController petController = PetController.getPetController();
        return petController.getPet(riac);
    }
}

