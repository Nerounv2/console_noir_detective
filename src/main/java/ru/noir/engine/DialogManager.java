package ru.noir.engine;

import ru.noir.model.entities.Detective;
import ru.noir.model.entities.DialogResult;
import ru.noir.model.entities.NPC;


public class DialogManager {



    //При вопросе у NPC про подозреваемых типа
    //"Был ти тут такой-то" будет возвращаться результат проверки его слов и подозреваемого
    public DialogResult askAboutSuspect(Detective detective, NPC responder, NPC suspect){
        if (responder.equals(suspect)){
            return new DialogResult(responder.getName() + ": \"" + responder.getAlibiText() + "\""
                    , false
                    , null);
        }

        if(suspect.isKiller()){
            return new DialogResult(responder.getName() + ": \"Я не видел " + suspect.getName() + " здесь в это время."
                    , true
                    , null);
        }

        else{
            return new DialogResult(responder.getName() + ": \"Да, " + suspect.getName() + " тут был"
                    , false
                    , null);
        }
    }
}
