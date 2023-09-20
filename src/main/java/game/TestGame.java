package game;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import player.Player;

public class TestGame {

    @Test

    public void testWhenFirstPlayerWin(){
        Game game = new Game();
        Player vasya = new Player(2,"Vasya",4);
        Player masha = new Player(3,"Masha",3);

        game.register(vasya);
        game.register(masha);

        int actual = game.round("Vasya", "Masha");
        int expected = 1;

        Assertions.assertEquals(actual,expected);
    }

    @Test

    public void testWhenSecondPlayerWin(){
        Game game = new Game();
        Player vasya = new Player(2,"Vasya",3);
        Player masha = new Player(3,"Masha",4);

        game.register(vasya);
        game.register(masha);

        int actual = game.round("Vasya", "Masha");
        int expected = 2;

        Assertions.assertEquals(actual,expected);
    }



    @Test
    public void testWhenNobodyWin(){
        Game game = new Game();
        Player vasya = new Player(2,"Vasya",4);
        Player masha = new Player(3,"Masha",4);

        game.register(vasya);
        game.register(masha);

        int actual = game.round("Vasya", "Masha");
        int expected = 0;

        Assertions.assertEquals(actual,expected);
    }

    @Test
    public void testWhenPlayerNotRegistered(){
        Game game = new Game();
        Player vasya = new Player(2,"Vasya",4);
        Player masha = new Player(3,"Masha",4);

        game.register(vasya);
        game.register(masha);

        int actual = game.round("Ilia", "Masha");


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ilia", "Masha");
        });
    }

}
