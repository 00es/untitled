package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum CommentStatus {
    VISIBLE,
    DELETED,
    BLINDED,
}
