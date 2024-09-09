package org.scoreboard.domain;

import java.util.Objects;

public record Team(String name) {

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return Objects.equals(name, team.name);
    }

}
