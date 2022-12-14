package mk.ukim.finki.wp.lab.converters;

import mk.ukim.finki.wp.lab.model.TeacherFullName;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TeacherFullNameConverter implements AttributeConverter<TeacherFullName, String>{
    private static final String SEPARATOR = " ";

    @Override
    public String convertToDatabaseColumn(TeacherFullName tfn){
        if(tfn == null)
            return null;

        StringBuilder sb = new StringBuilder();

        if(tfn.getName() != null && !tfn.getName().isEmpty()){
            sb.append(tfn.getName());
            sb.append(SEPARATOR);
        }

        if(tfn.getSurname() != null && !tfn.getSurname().isEmpty()){
            sb.append(tfn.getSurname());
        }

        return sb.toString();
    }

    @Override
    public TeacherFullName convertToEntityAttribute(String s){
        if(s==null || s.isEmpty())
            return null;

        String[] parts = s.split(SEPARATOR);
        if(parts.length == 0)
            return null;

        TeacherFullName tfn = new TeacherFullName();
        if (s.contains(SEPARATOR)) {
            tfn.setName(parts[0]);

            if (parts.length >= 2 && parts[1] != null
                    && !parts[1].isEmpty()) {
                tfn.setSurname(parts[1]);
            }
        } else {
            tfn.setSurname(parts[0]);
        }

        return tfn;
    }
}
