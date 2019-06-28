package com.xingyun.core;


public enum CondOfHyWq {
    DOX {
        @Override
        public boolean judeCond(int type,Double cond) {
            if(type==1){
                if (cond>=7.5){
                    return true;
                }
            }else if(type==2){
                if (cond>=6 && cond<7.5){
                    return true;
                }
            }else if(type==3){
                if (cond>=5 && cond<6){
                    return true;
                }
            }else if(type==4){
                if (cond>=3 && cond<5){
                    return true;
                }
            }else if(type==5){
                if (cond>=2 && cond<3){
                    return true;
                }
            }else if(type==6){
                if (cond<2){
                    return true;
                }
            }

            return false;
        }
    },
    CODMN{
        @Override
        public boolean judeCond(int type,Double cond){
            if(type==1){
                if (cond<=2){
                    return true;
                }
            }else if(type==2){
                if (cond>2 && cond<=4){
                    return true;
                }
            }else if(type==3){
                if (cond>4 && cond<=6){
                    return true;
                }
            }else if(type==4){
                if (cond>6 && cond<=10){
                    return true;
                }
            }else if(type==5){
                if (cond>10 && cond<=15){
                    return true;
                }
            }else if(type==6){
                if (cond>15){
                    return true;
                }
            }
            return false;
        }
    },
    CODCR{
        @Override
        public boolean judeCond(int type,Double cond){
            if(type==1){
                if (cond<15){
                    return true;
                }
            }else if(type==2){
                if (cond==15){
                    return true;
                }
            }else if(type==3){
                if (cond>15 && cond<=20){
                    return true;
                }
            }else if(type==4){
                if (cond>20 && cond<=30){
                    return true;
                }
            }else if(type==5){
                if (cond>30 && cond<=40){
                    return true;
                }
            }else if(type==6){
                if (cond>40){
                    return true;
                }
            }
            return false;
        }
    },
    NH4{
        @Override
        public boolean judeCond(int type,Double cond){
            if(type==1){
                if (cond<=0.15d){
                    return true;
                }
            }else if(type==2){
                if (cond>0.15d && cond<=0.5d){
                    return true;
                }
            }else if(type==3){
                if (cond>0.5d && cond<=1d){
                    return true;
                }
            }else if(type==4){
                if (cond>1d && cond<=1.5d){
                    return true;
                }
            }else if(type==5){
                if (cond>1.5d && cond<=2d){
                    return true;
                }
            }else if(type==6){
                if (cond>2d){
                    return true;
                }
            }
            return false;
        }
    },
    TP_LAKE{
        @Override
        public boolean judeCond(int type,Double cond){
            if(type==1){
                if (cond<=0.01d){
                    return true;
                }
            }else if(type==2){
                if (cond>0.01d && cond<=0.025d){
                    return true;
                }
            }else if(type==3){
                if (cond>0.025d && cond<=0.05d){
                    return true;
                }
            }else if(type==4){
                if (cond>0.05d && cond<=0.1d){
                    return true;
                }
            }else if(type==5){
                if (cond>0.1d && cond<=0.2d){
                    return true;
                }
            }else if(type==6){
                if (cond>0.2d){
                    return true;
                }
            }
            return false;
        }
    },
    TP_RIVER{
        @Override
        public boolean judeCond(int type,Double cond){
            if(type==1){
                if (cond<=0.02d){
                    return true;
                }
            }else if(type==2){
                if (cond>0.02d && cond<=0.1d){
                    return true;
                }
            }else if(type==3){
                if (cond>0.1d && cond<=0.2d){
                    return true;
                }
            }else if(type==4){
                if (cond>0.2d && cond<=0.3d){
                    return true;
                }
            }else if(type==5){
                if (cond>0.3d && cond<=0.4d){
                    return true;
                }
            }else if(type==6){
                if (cond>0.4d){
                    return true;
                }
            }
            return false;
        }
    },
    TN{
        @Override
        public boolean judeCond(int type,Double cond){
            if(type==1){
                if (cond<=0.2d){
                    return true;
                }
            }else if(type==2){
                if (cond>0.2d && cond<=0.5d){
                    return true;
                }
            }else if(type==3){
                if (cond>0.5d && cond<=1d){
                    return true;
                }
            }else if(type==4){
                if (cond>1d && cond<=1.5d){
                    return true;
                }
            }else if(type==5){
                if (cond>1.5d && cond<=2d){
                    return true;
                }
            }else if(type==6){
                if (cond>2D){
                    return true;
                }
            }
            return false;
        }
    };



    public abstract boolean judeCond(int type,Double cond);
}
