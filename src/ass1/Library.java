package ass1;

public class Library {
    String library_name;
    String library_address;
    public Library(String library_name,String library_address){
        this.library_name=library_name;
        this.library_address=library_address;
    }

    public String getLibrary_name() {
        return library_name;
    }

    public void setLibrary_name(String library_name) {
        this.library_name = library_name;
    }

    public String getLibrary_address() {
        return library_address;
    }

    public void setLibrary_address(String library_address) {
        this.library_address = library_address;
    }
}
