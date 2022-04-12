package enums;

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L");

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    private String abbreviation;
}
public class EnumDemo {
    public  static void main(String[] args) {
        Size size = Enum.valueOf(Size.class, "SMALL");
        System.out.println("size=" + size);
        System.out.println("Abbreviation is " + size.getAbbreviation());
    }
}
