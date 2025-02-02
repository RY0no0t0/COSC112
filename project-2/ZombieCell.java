public class ZombieCell extends Cell{

    public ZombieCell () {

        super();

    }

    // define abstract methods
    public String toString () {
        return "z";
    }

    public void evolve (){
        _willBeAlive = false;
    }

}