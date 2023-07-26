# SmartParking

This project is an application that takes the position of a car and finds the most efficient parking that the car should go to, with the path to take.

The application uses Dijkstra's algorithm to find the parking that takes the least amount of time to get to from a given position. 
The factors considered are:
- Amount of cars already in the parking.
- Amount of cars going in or out of the parking.
- Distance
- Speed limit

**Definitions**

- Nodes represent a position in the graph where the car could be located. Parking is a subclass of Node.
- Edges represent roads between two nodes. The graph is undirected.

**How it works**

- The user will be prompted to give their position in the graph and, since this is an application for testing purposes, choose the parameters of each parking.
- Each parking has a capacity, an occupancy, and a flux. The capacity dictates the number of cars that the parking can hold at maximum. The occupancy is the number of cars presently in the parking, and the flux is the average number of cars that are entering/exiting the parking per minute.
- The user will choose between a conservative option or an aggressive option. The conservative option takes into consideration the flux of the parking. For example, if a parking has a capacity of 50, an occupancy of 45, and a flux of 2, then within 3 minutes, the parking should be full. The conservative option will thus ignore that parking if it takes more than 3 minutes to reach it, even if it is the parking that will take the least amount of time to reach. However, an aggressive will choose it.
- Dijkstra's algorithm will then produce an arrayList of the paths available, the *closest* parking, and the shortest path to take to get to it.

**INTERFACE**
--
![image](https://github.com/ayman-lahdili/SmartParking/assets/97915928/f06b9f7f-804d-433d-847a-dc381d3a7e9f)

**SAFE**
Here, the algorithm finds that the Parking P2, although the shortest path, is already full, thus it finds the next closest one.
--
<img width="887" alt="image" src="https://github.com/ayman-lahdili/SmartParking/assets/97915928/e20eecb6-3f92-4e8f-92b3-7c3fd6599e30">

