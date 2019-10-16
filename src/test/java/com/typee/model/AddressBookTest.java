package com.typee.model;

import static com.typee.testutil.Assert.assertThrows;
//import static com.typee.testutil.TypicalPersons.ALICE;
//import static com.typee.testutil.TypicalPersons.getTypicalAddressBook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.typee.model.person.Person;
import com.typee.model.person.exceptions.DuplicatePersonException;
import com.typee.testutil.PersonBuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AddressBookTest {

    /*
    private final AddressBook addressBook = new HistoryManager(new AddressBook());

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), addressBook.getEngagementList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        AddressBook newData = getTypicalAddressBook();
        addressBook.resetData(newData);
        assertEquals(newData, addressBook);
    }

    @Test
    public void resetData_withDuplicatePersons_throwsDuplicatePersonException() {
        // Two persons with the same identity fields
        Person editedAlice = new PersonBuilder(ALICE).build();
        List<Person> newPersons = Arrays.asList(ALICE, editedAlice);
        AddressBookStub newData = new AddressBookStub(newPersons);

        assertThrows(DuplicatePersonException.class, () -> addressBook.resetData(newData));
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasEngagement(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(addressBook.hasEngagement(ALICE));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        addressBook.addEngagement(ALICE);
        assertTrue(addressBook.hasEngagement(ALICE));
    }

    @Test
    public void hasPerson_personWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addEngagement(ALICE);
        Person editedAlice = new PersonBuilder(ALICE).build();
        assertTrue(addressBook.hasEngagement(editedAlice));
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getEngagementList().remove(0));
    }


     */
    /**
     * A stub ReadOnlyAddressBook whose persons list can violate interface constraints.
     */
    /*
    private static class AddressBookStub implements ReadOnlyAddressBook {
        private final ObservableList<Person> persons = FXCollections.observableArrayList();

        AddressBookStub(Collection<Person> persons) {
            this.persons.setAll(persons);
        }

        @Override
        public ObservableList<Person> getEngagementList() {
            return persons;
        }
    }

     */

}
