package com.zerulus.entity;

import com.zerulus.graphics.Animation;
import com.zerulus.graphics.Sprite;
import com.zerulus.util.AABB;
import com.zerulus.util.Vector2f;
import com.zerulus.util.InputHandler;
import com.zerulus.util.MouseHandler;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player extends Entity {


    private int xImage = 0;
    private int yImage = 0;

    private Animation ani;

    private final int RIGHT = 0;
    private final int LEFT = 1;
    private final int DOWN = 2;
    private final int UP = 3;
    private int currentAnimation;

    public Player(Sprite sprite, Vector2f pos) {
        super(sprite, pos);

        ani = new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }

    private void setAnimation(int i, BufferedImage[] b, int d) {
        currentAnimation = i;
        ani.setFrames(b);
        ani.setDelay(d);
    }

    public void anim() {
        if(up) {
            if(currentAnimation != UP || ani.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP), 10);
            }
        }
        else if(down) {
            if(currentAnimation != DOWN || ani.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 10);
            }
        }
        else if(left) {
            if(currentAnimation != LEFT || ani.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 10);
            }
        }
        else if(right) {
            if(currentAnimation != RIGHT || ani.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }

    private void move() {
        if(up) {
			dy -= acc;
			if(dy < -maxSpeed) {
				dy = -maxSpeed;
			}
		} else {
			if(dy < 0) {
				dy += deacc;
				if(dy > 0) {
					dy = 0;
				}
			}
		}
		if (down) {
			dy += acc;
			if(dy > maxSpeed) {
				dy = maxSpeed;
			}
		} else {
			if(dy > 0) {
				dy -= deacc;
				if(dy < 0) {
					dy = 0;
				}
			}
		}
		if(left) {
			dx -= acc;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		} else {
			if(dx < 0) {
				dx += deacc;
				if(dx > 0) {
					dx = 0;
				}
			}
		}
		if(right) {
			dx += acc;
			if(dx > maxSpeed) {
				dx = maxSpeed;
			}
		} else {
			if(dx > 0) {
				dx -= deacc;
				if(dx < 0) {
					dx = 0;
				}
			}
		}
    }

    public boolean collision(float ax, float ay) {
        boolean solid = false;
        for(int c = 0; c < 4; c++) {
            //int xt = ((pos.x + ax) + c % 2 * 2 - 1) / 16;
            //int yt = ((pos.y + ay) + c / 2 * 2 - 1) / 16;
            //if same position as block return true;
            //level.getTile(xt, yt).solid()) solid = true;
        }
        return solid;
    }

    public void update() {
        anim();
        move();

        if(!collision(0, dy)) {
            pos.y += dy;
        }
        if(!collision(dx, 0)) {
            pos.x += dx;
        }

        ani.update();
    }

    public void render(Graphics2D g) {
        g.drawImage(ani.getImage(), (int) pos.x, (int) pos.y, size, size, null);
    }

    public void input(InputHandler keys, MouseHandler mouse) {
        if(keys.up.down) {
            up = true;
        } else {
            up = false;
        }
        if(keys.down.down) {
            down = true;
        } else {
            down = false;
        }
        if(keys.left.down) {
            left = true;
        } else {
            left = false;
        }
        if(keys.right.down) {
            right = true;
        } else {
            right = false;
        }
    }
}
