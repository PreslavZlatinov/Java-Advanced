package Exercise.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

       List<Trainer> trainers = new ArrayList<>();

        while (!input.equals("Tournament")){

            String[] inputArr = input.split("\\s+");

            String trainerName = inputArr[0];

            String pokemonName = inputArr[1];
            String pokemonElement = inputArr[2];
            int pokemonHealth = Integer.parseInt(inputArr[3]);

            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,pokemonHealth);

            boolean trainerExists = trainers.stream().filter(tr -> tr.getName().equals(trainerName)).count() >= 1;

            if(!trainerExists){
                trainers.add(new Trainer(trainerName));
            }

            Trainer currentTrainer = trainers.stream()
                    .filter(tr -> tr.getName().equals(trainerName)).findFirst().get();

            currentTrainer.getPokemons().add(pokemon);


            input = scanner.nextLine();
        }

        String elementToSearch = scanner.nextLine();

        while (!elementToSearch.equals("End")){

            for (Trainer trainer : trainers) {
                boolean isFound = false;
                int currentBadges = trainer.getBadges();
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if(pokemon.getElement().equals(elementToSearch)){
                        isFound = true;
                        break;
                    }
                }
                if(isFound){
                    currentBadges++;
                    trainer.setBadges(currentBadges);
                } else{
                    for (Pokemon pokemon : trainer.getPokemons()) {
                        int healthToAdd = pokemon.getHealth() - 10;
                        pokemon.setHealth(healthToAdd);
                    }
                }

                List<Pokemon> newPokemonList = trainer.getPokemons()
                        .stream()
                        .filter(pokemon -> pokemon.getHealth() > 0)
                        .collect(Collectors.toList());

                trainer.setPokemons(newPokemonList);
            }

            elementToSearch = scanner.nextLine();
        }

        trainers.stream()
                .sorted((tr1,tr2)-> Integer.compare(tr2.getBadges(),tr1.getBadges()))
                .forEach(System.out::println);
    }
}
