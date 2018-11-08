package za.ac.afm.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ResponseMessage {
    private String message;
    private boolean error;

    public ResponseMessage() {
    }

    public ResponseMessage(boolean error,String message) {
        this.message = message;
        this.error = error;
    }
}
