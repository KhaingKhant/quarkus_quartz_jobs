package org.acme.quartz.model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExtensionDto {
    public String name;
    public String shortName;
//    public List<String> keywords;
    @Override
    public String toString() {
        return "Extension{" +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}