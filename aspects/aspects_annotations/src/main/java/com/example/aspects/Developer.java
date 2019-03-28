package com.example.aspects;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    private String name;
    private String specialty;
    private String experience;

    public void throwSomeMysticException(){
        System.out.println("We have some strange and mystic exception here:");
        throw new ClassCastException();
    }

    @Override
    public String toString() {
        return "Developer:\n" +
                "Name: " + name + '\n' +
                "Specialty: " + specialty + '\n' +
                "Experience: " + experience + "\n";
    }
}
