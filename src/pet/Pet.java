package pet;

public class Pet {
    protected String name;
    protected Gender gender;
    protected String surname;
    protected AnimalType animalType;
    protected NaoInformado isInformedName;
    protected NaoInformado isInformedAge;
    protected NaoInformado isInformedNumberAdress;
    protected NaoInformado isInformedWeight;
    protected NaoInformado isInformedBreed;
    protected AnimalType animal;
    protected String completeName;
    protected String breed;
    protected String numberAndress;
    protected String cityAdress;
    protected String streetAndress;
    protected double weight;
    protected int age;

    public NaoInformado getIsInformedName() {
        return isInformedName;
    }

    public void setIsInformedName(NaoInformado isInformedName) {
        this.isInformedName = isInformedName;
    }

    public NaoInformado getIsInformedAge() {
        return isInformedAge;
    }

    public void setIsInformedAge(NaoInformado isInformedAge) {
        this.isInformedAge = isInformedAge;
    }

    public NaoInformado getIsInformedNumberAdress() {
        return isInformedNumberAdress;
    }

    public void setIsInformedNumberAdress(NaoInformado isInformedNumberAdress) {
        this.isInformedNumberAdress = isInformedNumberAdress;
    }

    public NaoInformado getIsInformedWeight() {
        return isInformedWeight;
    }

    public void setIsInformedWeight(NaoInformado isInformedWeight) {
        this.isInformedWeight = isInformedWeight;
    }

    public NaoInformado getIsInformedBreed() {
        return isInformedBreed;
    }

    public void setIsInformedBreed(NaoInformado isInformedBreed) {
        this.isInformedBreed = isInformedBreed;
    }

    public AnimalType getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalType animal) {
        this.animal = animal;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getNumberAndress() {
        return numberAndress;
    }

    public void setNumberAndress(String numberAndress) {
        this.numberAndress = numberAndress;
    }

    public String getCityAdress() {
        return cityAdress;
    }

    public void setCityAdress(String cityAdress) {
        this.cityAdress = cityAdress;
    }

    public String getStreetAndress() {
        return streetAndress;
    }

    public void setStreetAndress(String streetAndress) {
        this.streetAndress = streetAndress;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
