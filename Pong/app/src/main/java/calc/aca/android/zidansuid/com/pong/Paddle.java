package calc.aca.android.zidansuid.com.pong;

import android.graphics.RectF;

/**
 * Created by zidansuid on 10/3/16.
 */

public class Paddle {

    //Paddle members
    // RectF is an object that holds four coordinates// - just what we need
    private RectF mRect;

    // How long and high our mPaddle will be
    private float mLength;
    private float mHeight;

    // X is the far left of the rectangle which forms our mPaddle
    private float mXCoord;

    // Y is the top coordinate
    private float mYCoord;

    // This will hold the pixels per second speed that
    // the mPaddle will move
    private float mPaddleSpeed;

    // Which ways can the mPaddle move
    public final int STOPPED = 0;
    public final int LEFT = 1;
    public final int RIGHT = 2;

    // Is the mPaddle moving and in which direction
    private int mPaddleMoving = STOPPED;

    // The screen length and width in pixels
    private int mScreenX;
    private int mScreenY;
    // Adding Paddle constructor
    // This is the constructor method
    // When we create an object from this class we will pass
    // in the screen width and mHeight
    public Paddle(int x, int y){

        mScreenX = x;
        mScreenY = y;

        // 1/8 screen width wide
        mLength = mScreenX / 8;

        // 1/25 screen mHeight high
        mHeight = mScreenY / 25;

        // Start mPaddle in roughly the screen center
        mXCoord = mScreenX / 2;
        mYCoord = mScreenY - 20;

        mRect = new RectF(mXCoord, mYCoord, mXCoord + mLength, mYCoord + mHeight);

        // How fast is the mPaddle in pixels per second
        mPaddleSpeed = mScreenX;
        // Cover entire screen in 1 second
    }
     //Add the public getter to return the RectF that represents the paddle's location
     // This is a getter method to make the rectangle that
     // defines our paddle available in GameView class
     public RectF getRect(){
         return mRect;
     }

     // This method will be used to change/set // if the mPaddle is going
     // left, right or nowhere

    public void setMovementState(int state){
        mPaddleMoving = state;
    }
    // This update method will be called from update in GameView
    // It determines if the paddle needs to move // and changes the coordinates
    // contained in mRect if necessary
    public void update(long fps){
        if(mPaddleMoving == LEFT){
            mXCoord = mXCoord - mPaddleSpeed / fps;
        }
        if(mPaddleMoving == RIGHT){
            mXCoord = mXCoord + mPaddleSpeed / fps;
        }

        // Make sure it's not leaving screen
        if(mRect.left < 0){
            mXCoord = 0;
        }

        if(mRect.right > mScreenX){
            mXCoord = mScreenX -
                    // The width of the paddle
                    (mRect.right - mRect.left);
        }

        // Update the paddle graphics
        mRect.left = mXCoord;
        mRect.right = mXCoord + mLength;
    }

}
