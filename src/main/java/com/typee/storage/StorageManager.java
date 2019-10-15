package com.typee.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import com.typee.commons.core.LogsCenter;
import com.typee.commons.exceptions.DataConversionException;
import com.typee.model.ReadOnlyAddressBook;
import com.typee.model.ReadOnlyUserPrefs;
import com.typee.model.UserPrefs;
import com.typee.ui.Tab;

import javafx.collections.ObservableList;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private AddressBookStorage addressBookStorage;
    private UserPrefsStorage userPrefsStorage;
    //Adding TypeeStorage unit
    private TypeeStorage typeeStorage;

    public StorageManager(AddressBookStorage addressBookStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.addressBookStorage = addressBookStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    public StorageManager(AddressBookStorage addressBookStorage, UserPrefsStorage userPrefsStorage,
                          TypeeStorage typeeStorage) {
        super();
        this.addressBookStorage = addressBookStorage;
        this.userPrefsStorage = userPrefsStorage;
        this.typeeStorage = typeeStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getAddressBookFilePath() {
        return addressBookStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return addressBookStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveAddressBook(addressBook, filePath);
    }

    // ================ TYPEE methods ==============================
    @Override
    public ObservableList<Tab> getTabList() throws DataConversionException {
        logger.fine("Fetching tab list data from text file.");
        return typeeStorage.getTabList();
    }
}