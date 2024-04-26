package grp.info.serpentechelles;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.*;

public class HelloController
{
    @FXML
    Button jouer;
    @FXML
    Label De;
    @FXML
    Label joueurQuiJoue;

    @FXML
    private GridPane grille;

    private int positionJoueur1 = 1;
    private int positionJoueur2 = 1;

    Map<Integer,Integer> obstacles = new HashMap<>();
    private Random rand = new Random();

    private boolean tourJoueur1 = true;

    private int randomRange(int a, int b)
    {
        return rand.nextInt(b- a) + a;
    }

    @FXML
    void initialize()
    {
        initObstacles();
    }
    void initObstacles()
    {
        //Echelles
        obstacles.put(3,11);
        obstacles.put(13,25);
        obstacles.put(21,34);
        obstacles.put(27,29);
        obstacles.put(40,45);

        //Serpents
        obstacles.put(14,1);
        obstacles.put(24,8);
        obstacles.put(38,26);
        obstacles.put(43,31);
        obstacles.put(48,37);

    }
    @FXML
    private void jouerTour()
    {
        int valeurDe = randomRange(1,7);

        if (tourJoueur1)
        {
            positionJoueur1 += valeurDe;
            tourJoueur1 = false;
        }
        else
        {
            positionJoueur2 += valeurDe;
            tourJoueur1 = true;
        }
        obstacleEvent();
    }


    void obstacleEvent()
    {
        if (tourJoueur1)
        {
            if(obstacles.containsKey(positionJoueur1))
                positionJoueur1 = obstacles.get(positionJoueur1);
        }
        else
        {
            if(obstacles.containsKey(positionJoueur2))
                positionJoueur2 = obstacles.get(positionJoueur2);
        }
    }



    void obstacleEvent(int joueur)
    {
        // 24
        int ColonneInd = 0,ligneInd = 0;
        ligneInd =  grille.getRowCount() - joueur / grille.getColumnCount() - 1;
        if(ligneInd % 2 == 1)
            ColonneInd = grille.getColumnCount() - joueur % grille.getColumnCount();
        else
            ColonneInd = joueur % grille.getColumnCount() - 1;
    }
}