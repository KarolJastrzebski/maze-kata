Assumptions and notes

- Only walls and undefined locations block movement.
- The Explorer is not able to go to undefined locations.
- Maze can have any shape, not only rectangular. Although, haven't tested for edge cases.
- Finish point is not required. Explorer can step onto that field without any consequences.
- Tracker contains history of Pose changes and is able to return set of visited locations.
- Explorer exists only for one Maze. Teaching Explorer to enter and leave mazes would require refactoring.
- Maze can have multiple Explorers. Its instance can be shared between Explorers as it's not modified by any of them.
- TextMazePrinter allows for printing a maze along with Explorer on the map.
- As usual, tests should tell the story.
