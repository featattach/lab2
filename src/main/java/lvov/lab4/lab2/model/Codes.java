package lvov.lab4.lab2.model;

public enum Codes {
    SUCCESS("success"),
    FAILED("failed");
    private final String name;
    Codes(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return name;
    }

}
