package com.xingyun.core;

import com.xingyun.model.Wqlake;
import com.xingyun.model.Wqriver;
import com.xingyun.util.EmptySentence;

public class UseCondOfHyWq {
    public static boolean usecond(String strCond, int type, Wqriver wqriver){
        switch (strCond){
            case "DOX":
                return CondOfHyWq.DOX.judeCond(type,EmptySentence.judeEmpty(wqriver.getDox()));
            case "CODMN":
                return CondOfHyWq.CODMN.judeCond(type,EmptySentence.judeEmpty(wqriver.getCodmn()));
            case "CODCR":
                return CondOfHyWq.CODCR.judeCond(type,EmptySentence.judeEmpty(wqriver.getCodcr()));
            case "NH4":
                return CondOfHyWq.NH4.judeCond(type,EmptySentence.judeEmpty(wqriver.getNh4()));
            case "TP_RIVER":
                return CondOfHyWq.TP_RIVER.judeCond(type,EmptySentence.judeEmpty(wqriver.getTp()));
            case "TN":
                return CondOfHyWq.TN.judeCond(type,EmptySentence.judeEmpty(wqriver.getTn()));
        }
        return false;
    }

    public static boolean usecond(String strCond, int type, Wqlake wqlake){
        switch (strCond){
            case "DOX":
                return CondOfHyWq.DOX.judeCond(type,EmptySentence.judeEmpty(wqlake.getDox()));
            case "CODMN":
                return CondOfHyWq.CODMN.judeCond(type,EmptySentence.judeEmpty(wqlake.getCodmn()));
            case "CODCR":
                return CondOfHyWq.CODCR.judeCond(type,EmptySentence.judeEmpty(wqlake.getCodcr()));
            case "NH4":
                return CondOfHyWq.NH4.judeCond(type,EmptySentence.judeEmpty(wqlake.getNh4()));
            case "TP_LAKE":
                return CondOfHyWq.TP_RIVER.judeCond(type,EmptySentence.judeEmpty(wqlake.getTp()));
            case "TN":
                return CondOfHyWq.TN.judeCond(type,EmptySentence.judeEmpty(wqlake.getTn()));
        }
        return false;
    }
}
