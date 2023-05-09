package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WidgetBody {

    private Object description;
    private Object name;
    private ArrayList contentParameters;

}
