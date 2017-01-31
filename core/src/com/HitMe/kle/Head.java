package com.HitMe.kle;

import com.nilunder.bdx.*;

public class Head extends GameObject {

    public static class GameState extends Component{

        private GameObject playbutton,endButton,play1Button;
        private Player player;

        public GameState(GameObject g) {
            super(g);
            playbutton = g.scene.objects.get("Play");
            playbutton.components.add(new Button(playbutton));

            endButton = g.scene.objects.get("Button1");
            play1Button = g.scene.objects.get("Button2");
            endButton.components.add(new Button1(endButton));
            play1Button.components.add(new Button2(play1Button));

            Scene mainScene = Bdx.scenes.get("Main");
            player = (Player)mainScene.objects.get("Player");
            state = menu;
        }

        private State menu = new State(){
            public void main(){
                if(Bdx.mouse.clicked(playbutton)){
                    g.scene.camera.position(g.scene.objects.get("PlayView").position());
                    state = play;
                    player.canThrowBottles = true;
                }
            }
        };

        private State play = new State(){
            private Platform platform;
            public void main(){
                Scene mainScene = Bdx.scenes.get("Main");
                platform = (Platform) mainScene.objects.get("Platform");
                if(platform.hit("Bottle")) {
                    player.canThrowBottles = false;
                    g.scene.camera.position(g.scene.objects.get("IntermediateView").position());
                }
                if(Bdx.mouse.clicked(play1Button)){
                    g.scene.camera.position(g.scene.objects.get("PlayView").position());
                    state = play;
                    player.canThrowBottles = true;
                }
                if(Bdx.mouse.clicked(endButton)){
                    System.exit(0);
                }
            }
        };
    }

////////////////////

    public static class Button extends Component{

        private GameObject playbutton;

        public Button(GameObject g) {
            super(g);
            playbutton = g.scene.objects.get("Play");
            state = normal;
        }

        private State normal = new State(){
            public void main(){
                if(mouseOver()){
                    g.scale(0.6f,0.3f,0.1f);
                    state = mouseOver;
                }
            }
        };

        private State mouseOver = new State(){
            public void main(){
                if(!mouseOver()){
                    playbutton.scale(0.5f,0.2f,0.1f);
                    state = normal;
                }
            }
        };

        public boolean mouseOver(){
            RayHit rh = Bdx.mouse.ray();
            return rh != null && rh.object == g;
        }
    }
//////////////////////////

    public static class Button1 extends Component{

        private GameObject menubutton;

        public Button1(GameObject g) {
            super(g);
            menubutton = g.scene.objects.get("Button1");
            state = normal;
        }

        private State normal = new State(){
            public void main(){
                if(mouseOver()){
                    g.scale(0.5f,0.3f,0.1f);
                    state = mouseOver;
                }
            }
        };

        private State mouseOver = new State(){
            public void main(){
                if(!mouseOver()){
                    menubutton.scale(0.45f,0.15f,0.1f);
                    state = normal;
                }
            }
        };

        public boolean mouseOver(){
            RayHit rh = Bdx.mouse.ray();
            return rh != null && rh.object == g;
        }
    }
///////////////////////////
    public static class Button2 extends Component{

        private GameObject play1button;

        public Button2(GameObject g) {
            super(g);
            play1button = g.scene.objects.get("Button2");
            state = normal;
        }

        private State normal = new State(){
            public void main(){
                if(mouseOver()){
                    g.scale(0.5f,0.3f,0.1f);
                    state = mouseOver;
                }
            }
        };

        private State mouseOver = new State(){
            public void main(){
                if(!mouseOver()){
                    play1button.scale(0.45f,0.15f,0.1f);
                    state = normal;
                }
            }
        };

        public boolean mouseOver(){
            RayHit rh = Bdx.mouse.ray();
            return rh != null && rh.object == g;
        }
    }
 /////////////////////////////
    public void init(){
        components.add(new GameState(this));
    }
}
