/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
//
//package game;
//
//import city.cs.engine.*;
//import city.cs.engine.Shape;
//import org.jbox2d.common.Vec2;
//
//
//
//public class GameWorld extends World {
//    private mario character;
//    private coin token;
//
//    public void setCharacter() {
//        //  make mario
//        character = new mario(this);
//        character.setPosition(new Vec2(-0, -19));
//
//    }
//

//
//    public void setPlatform(){
//        // make a platforms (with images)
//
//        //top left
//        Shape platformShape = new BoxShape(3, 0.5f);
//        Body platform1 = new StaticBody(this, platformShape);
//        platform1.setPosition(new Vec2(-9, 5.5f));
//        platform1.addImage(new BodyImage("data/platform.png", 1.25f));
//
//        // top right
//        Body platform3 = new StaticBody(this, platformShape);
//        platform3.setPosition(new Vec2(12, 5.5f));
//        platform3.setAngleDegrees(15);
//        platform3.addImage(new BodyImage("data/platform.png", 1.25f));
//    }
//
//   // public void setCoin(){
//        //coin
//
//        //right coin
////
////        token = new coin(this);
////        token.setPosition(new Vec2(12,5.5f));
////        token.setGravityScale(0);
////
////
////
////
////        //left coin
////        coin token1= new coin(this);
////        token1.setPosition(new Vec2(-9,5.5f));
////        token1.setGravityScale(0);
////
////
////        //middle coin
////        coin token2= new coin(this);
////        token2.setPosition(new Vec2(0,1.5f));
////        token2.setGravityScale(0);
//
// //   }
//
//    public void setBoo(){
//        //moving boo in a for loop
//        for (int i = 0; i<1000; i=i+10) {
//
//            boo ball= new boo(this);
//            ball.setPosition(new Vec2(i+10,-0.3f));
//            ball.startWalking(-4);
//            ball.setGravityScale(0);
//
//            boo ball1 = new boo(this);
//            ball1.setPosition(new Vec2(i, -10.5f));
//            ball1.startWalking(-1);
//            ball1.setGravityScale(0);
//        }
//
//    }
//
//    public void setmovingPlatform(){
//        // moving platforms
//        for (int i = 0; i<10000; i=i+8) {
//            platform rect = new platform(this);
//            rect.setPosition(new Vec2(i, -5.5f));
//            rect.startWalking(-16);
//            rect.setGravityScale(0);
//            rect.setAngularVelocity(6.5f);
//        }
//    }
//
//    public GameWorld() {
//
//        super();
//        // Keep it stupid simple
//        //KISS: Learnt to have only one method for one code use case
//        // Don't repeat yourself
//        //DRY: This also makes it easy to reuse a block of code
//



//        //setCoins
//        setCoin();
//        //set boo
//        setBoo();
//        //set moving platform
//        setmovingPlatform();
//    }
//
//
//    public mario getPlayer(){
//        return this.character;
//    }
//
//    public coin getCoin(){
//        return this.token;
//    }
//}
//
//
//
//
//// links to images
//// coins - https://pngtree.com/freepng/hand-drawn-new-year-gold-coin-cartoon-transparent-material_4389595.html
//// boo- https://www.pikpng.com/pngvi/JTbJJ_boo-super-mario-world-boo-pixel-art-clipart/
//// Luigi but called Mario - http://pngimg.com/download/30555
//// platform- https://opensource.com/article/18/7/put-platforms-python-game
//// platform1 (rotating)- https://img.neoseeker.com/v_concept_art.php?caid=22404
//
//
//
//
//
//
//
//
//
//
//
//
