package quiz.model;

public class AddressBookItem {

        public String name;
        public String address;

        public AddressBookItem() {
	    // TODO Auto-generated constructor stub
        }

        public AddressBookItem(String name, String address) {
	    this.name = name;
	    this.address = address;
        }

        @Override
        public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (getClass() != obj.getClass()) return false;
	    AddressBookItem other = (AddressBookItem) obj;
	    if (!this.name.equalsIgnoreCase(other.name)) return false;
	    return true;
        }

}
