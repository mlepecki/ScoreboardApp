# ScoreboardApp
Simple JAVA library to manage soccer Scoreboard

## Overview

The Scoreboard Application is a Java-based library designed to manage and track scores for sports matches. The application supports functionalities such as starting new matches, updating scores, finishing matches, and generating summaries of ongoing matches. Matches are identified by unique IDs, and the system handles various edge cases with appropriate exception handling.

## Features

- **Start a New Match**: Initializes a new match with a default score of 0-0 and assigns a unique ID.
- **Update Score**: Allows updating the score for a specific match using its unique ID.
- **Finish Match**: Ends an ongoing match and removes it from the scoreboard.
- **Get Match Report**: Retrieves a summary of ongoing matches, ordered by total score and, if scores are equal, by the most recent start time.
- **Exception Handling**: Includes handling for non-existent matches and invalid scores.

## Tech Stack

- **Language**: Java
- **Build Tool**: Maven
- **Testing Framework**: JUnit
- **Exception Handling**: Custom exceptions for improved error handling

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/mlepecki/ScoreboardApp.git
   cd ScoreboardApp

2. **Build the project**
   ```shell
   mvn clean install               
3. **To generate JAR package**
   ```shell
   mvn package

## Example of usage
   ```java
   // Create a new instance of scoreboard 
   Scoreboard scoreboard = new Scoreboard();
   Team teamA = new Team("Team A");
   Team teamB = new Team("Team B");

   // Start a match
   String matchId = scoreboard.startMatch(teamA, teamB);

   // Update the score
   scoreboard.updateScore(matchId, 1, 2);

   // Finish the match
   scoreboard.finishMatch(matchId);

   // Get the summary report of ongoing matches
   List<Match> summary = scoreboard.getReport();
   ```

## Exception handling
- MatchNotFoundException: Thrown when attempting to update or finish a non-existent match.
- IllegalScoreException: Thrown when invalid scores (e.g., negative values) are provided.

## Running tests
   ```shell
   mvn test
   ```


  