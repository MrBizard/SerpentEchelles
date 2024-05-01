package grp.info.serpentechelles;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.*;

public class ModelJeu
{
    @FXML
    Button jouer;

    @FXML
    ImageView joueur1;
    @FXML
    ImageView joueur2;

    @FXML
    ImageView faceDe1;
    @FXML
    ImageView faceDe2;
    @FXML
    ImageView faceDe3;
    @FXML
    ImageView faceDe4;
    @FXML
    ImageView faceDe5;
    @FXML
    ImageView faceDe6;

    @FXML
    Label joueurQuiJoue;

    @FXML
    private GridPane grilleJeu;

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
        obstacles.put(6,9);
        obstacles.put(13,16);
        obstacles.put(20,33);
        obstacles.put(41,45);

        //Serpents
        obstacles.put(11,4);
        obstacles.put(32,17);
        obstacles.put(34,22);
        obstacles.put(40,28);
        obstacles.put(48,37);

    }

    @FXML
    private void jouerTour()
    {
        int valeurDe = randomRange(1,7);
        afficherDe(valeurDe);
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
        updateJoueur();
    }


    void obstacleEvent()
    {
        if (tourJoueur1)
        {
            if(obstacles.containsKey(positionJoueur1))
                positionJoueur1 = obstacles.get(positionJoueur1);
            joueurQuiJoue.setText("joueur 2");
        }
        else
        {
            if(obstacles.containsKey(positionJoueur2))
                positionJoueur2 = obstacles.get(positionJoueur2);
            joueurQuiJoue.setText("joueur 1");
        }
    }

    void updateJoueur()
    {
        int ColonneInd = 0,ligneInd = 0;
        ligneInd = grilleJeu.getRowCount() - positionJoueur1 / grilleJeu.getColumnCount() - 1;
        if(ligneInd % 2 == 1)
            ColonneInd = grilleJeu.getColumnCount() - positionJoueur1 % grilleJeu.getColumnCount();
        else
            ColonneInd = positionJoueur1 % grilleJeu.getColumnCount() - 1;
        grilleJeu.setRowIndex(joueur1,ligneInd);
        grilleJeu.setColumnIndex(joueur1,ColonneInd);

        ligneInd = grilleJeu.getRowCount() - positionJoueur2 / grilleJeu.getColumnCount() - 1;
        if(ligneInd % 2 == 1)
            ColonneInd = grilleJeu.getColumnCount() - positionJoueur2 % grilleJeu.getColumnCount();
        else
            ColonneInd = positionJoueur2 % grilleJeu.getColumnCount() - 1;
        grilleJeu.setRowIndex(joueur2,ligneInd);
        grilleJeu.setColumnIndex(joueur2,ColonneInd);
    }



    void afficherDe(int de)
    {
        faceDe1.setVisible(false);
        faceDe2.setVisible(false);
        faceDe3.setVisible(false);
        faceDe4.setVisible(false);
        faceDe5.setVisible(false);
        faceDe6.setVisible(false);
        switch (de) {
            case 0:
                faceDe1.setVisible(true);
                break;
            case 1:
                faceDe2.setVisible(true);
                break;
            case 2:
                faceDe3.setVisible(true);
                break;
            case 3:
                faceDe4.setVisible(true);
                break;
            case 4:
                faceDe5.setVisible(true);
                break;
            case 5:
                faceDe6.setVisible(true);
                break;
            case 6:
                break;
        }
    }
}