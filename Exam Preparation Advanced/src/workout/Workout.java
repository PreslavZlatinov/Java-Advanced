package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return exerciseCount;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }


    public int getExerciseCount(){
        return this.exercises.size();
    }

    public void addExercise(Exercise exercise) {
        if(getExerciseCount() < exerciseCount){
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream()
                .filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle))
                .findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparingInt(Exercise::getBurnedCalories)).orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n",type));

        exercises.forEach(exercise -> sb.append(exercise.toString()).append(String.format("%n")));

        return sb.toString().trim();
    }
}
