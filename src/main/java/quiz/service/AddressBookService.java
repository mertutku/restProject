package quiz.service;

import java.util.ArrayList;
import java.util.List;

import quiz.model.AddressBookItem;

public class AddressBookService {

        private List<AddressBookItem> items = new ArrayList();

        public AddressBookService() {
	    items.add(new AddressBookItem("mert", "address1"));
	    items.add(new AddressBookItem("miray", "address2"));
        }

        public List<AddressBookItem> list() {
	    return items;
        }

        public void add(String name, String address) {
	    items.add(new AddressBookItem(name, address));
        }

        public boolean update(String name, String address) {
	    for (AddressBookItem item : items) {
		if (item.name.equals(name)) {
		        item.address = address;
		        return true;
		}
	    }
	    return false;

        }

        public boolean delete(String name) {
	    return items.remove(new AddressBookItem(name, null));
        }
}
