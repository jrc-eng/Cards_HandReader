/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards_handreader;

import card52.Card;
import card52.Suit;
import handsystem.Hand;
import static handsystem.Hand.HAND_LENGTH;
import imageGetter.CardImageGetter;
import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jrcro
 */
public class Cards_HandReader extends Application {
    
    Hand hand;
    
    ImageView i1,i2,i3,i4,i5;
    
    Button r1, r2, r3, r4, r5;
    
    Button s1, s2, s3, s4, s5;
    
    GridPane root;
    private int MAX_RANK;
    
    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });

         hand = new Hand();

         System.out.println(hand.getCardAtPos(0).toString());
        //Pane 1: The Five Cards:
       
        root = new GridPane();
        
        root.setPadding(new Insets(10,10,10,10));
        root.setAlignment(Pos.CENTER);
        
        root.setHgap(8);
        root.setVgap(8);
       
        ArrayList<Card> cards = hand.getCardHand();
        
        i1 = new ImageView("file:img/" +CardImageGetter.getStringFromCard(cards.get(0)));
        i2 = new ImageView("file:img/" +CardImageGetter.getStringFromCard(cards.get(1)));
        i3 = new ImageView("file:img/" +CardImageGetter.getStringFromCard(cards.get(2)));
        i4 = new ImageView("file:img/" +CardImageGetter.getStringFromCard(cards.get(3)));
        i5 = new ImageView("file:img/" +CardImageGetter.getStringFromCard(cards.get(4)));
        
        root.add(i1,0,0);
        root.add(i2,1,0);
        root.add(i3,2,0);
        root.add(i4,3,0);
        root.add(i5,4,0);
        
        
        r1 = new Button("Rank");
        
        s1 = new Button("Suit");
        
        r1.setOnAction((e) ->{
            
            changeCardRank(0);
        });
        
        s1.setOnAction((e) ->{
        
            changeCardSuit(0);
        });

        
        root.add(r1, 0,1);
        root.add(s1, 0,2);
        
        //new ImageView(new File(CardImageGetter.getStringFromCard(cards.get(x))).toURI().toString());
        
        
        
        
        
        //root.getChildren().add(new Button("Ok"));
        
        //root.getChildren().add(btn);
        
        Scene scene = new Scene(root,330,280);
        
        primaryStage.setTitle("Card Hand Reader");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void changeCardRank(int cardPos)
    {
        Card c = hand.getCardAtPos(cardPos);
        
        int rank = c.getRank();
        
        
        
        System.out.println(rank);
        rank = rank+1;
        System.out.println(rank);
        
        if(rank > 14)
        {
            rank = 2;
        }
        
        c.setRank(rank);
        
        hand.setCardAtPos(c, cardPos);
        renderImages();
    }
    
    public void changeCardSuit(int cardPos)
    {
        Card c = hand.getCardAtPos(cardPos);
        
        Suit suit = c.getSuit();
        
        switch(suit)
        {
            case SPADE:
                suit = Suit.HEART;
                break;
            case HEART:
                suit = Suit.DIAMOND;
                break;
            case DIAMOND:
                suit = Suit.CLUB;
                break;
            case CLUB:
                suit = Suit.SPADE;
                break;
        }
        
        c.setSuit(suit);
        
        hand.setCardAtPos(c, cardPos);
        
        renderImages();
    }
    
    public void renderImages()
    {
        ArrayList<Card> cards = hand.getCardHand();
        
        System.out.println(CardImageGetter.getStringFromCard(cards.get(0)));
        
        i1.setImage(new Image("file:img/" +CardImageGetter.getStringFromCard(cards.get(0))));
        i2.setImage(new Image("file:img/" +CardImageGetter.getStringFromCard(cards.get(1))));
        i3.setImage(new Image("file:img/" +CardImageGetter.getStringFromCard(cards.get(2))));
        i4.setImage(new Image("file:img/" +CardImageGetter.getStringFromCard(cards.get(3))));
        i5.setImage(new Image("file:img/" +CardImageGetter.getStringFromCard(cards.get(4))));
    }
    
    
}
