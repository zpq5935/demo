package one.zpq.request;


import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseRequest implements Serializable {
    private String groupId;
}
