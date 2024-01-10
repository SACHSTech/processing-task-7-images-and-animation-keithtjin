import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  float x1, y1, x2, y2; // Variables for edge detection
  float angle = 0; // Variable for non-linear animation

  PImage backgroundImage;
  PImage animatedImage;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    size(400, 400);
  }

  /**
   * Called once at the beginning of execution. Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    backgroundImage = loadImage("background.jpg"); // Replace with your background image
    animatedImage = loadImage("animated.png"); // Replace with your animated image
    x1 = 50;
    y1 = height / 2;
    x2 = width - 50;
    y2 = height / 2;
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(backgroundImage);
    
    // Level 2: Animate a shape
    drawAnimatedShape();

    // Level 3: Basic edge detection for the shape
    checkEdges();

    // Level 4: Animate an image in a non-linear path (circular in this case)
    drawNonLinearAnimation();
  }

  // Level 2: Animate a shape
  private void drawAnimatedShape() {
    fill(255, 0, 0);
    ellipse(x1, y1, 30, 30);
    x1 += 2;
  }

  // Level 3: Basic edge detection
  private void checkEdges() {
    if (x1 > width) {
      x1 = 0;
    }
  }

  // Level 4: Animate an image in a circular path
  private void drawNonLinearAnimation() {
    float offsetX = cos(angle) * 100;
    float offsetY = sin(angle) * 50;
    image(animatedImage, width / 2 + offsetX, height / 2 + offsetY);
    angle += 0.05;
  }
}
