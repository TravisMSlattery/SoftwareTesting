import static java.lang.Thread.sleep;

public class Robot {

    private String name;
    private boolean working = false;
    private int age;


    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public Robot(String name) {
        setName(name);

    }
    public Robot(String name,int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age <= 30){
            this.age = age;
        }else{
            throw new IllegalArgumentException();
        }

    }

    public boolean isWorking(){
        return working;
    }

    public void poweredOn(){
        working = true;
    }
    public void poweredOff(){
        working = false;
    }

    public String getWarning(){
        if(!working) {
            throw new IllegalStateException();
        }
        return "I am in working mode";

    }

    public String checkage() {
        if (age <= 20) {
            return "Age ok";
        } else {
            return "Too old";
        }

    }
        public void waitTillWorking() throws InterruptedException{
        sleep(100);
    }
    public void sendAgeMsg() throws IllegalArgumentException {
        try {
            if (age > 25) {
                throw new IllegalArgumentException("Age too old");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
        System.out.println( "Age ok");
    }



}

