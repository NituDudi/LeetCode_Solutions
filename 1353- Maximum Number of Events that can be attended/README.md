# 1353- Maximum Number of Events That can be Attended

## Problem Statement

You are given a list of events, where each event has a start day and an end day. Each event is represented as an array [startDay, endDay].
The goal is to attend the maximum number of events. You can only attend one event per day, and you can only attend an event on a day between its start and end day (inclusive).

## Approach

1. First, sort the events by their start day.
2. Use a min-heap (priority queue) to keep track of the end days of events that can be attended on each day.
3. Go through each day one by one, from the earliest to the latest possible day.
4. On each day:
   - Add all events that start on that day to the min-heap.
   - Remove any events from the heap that have already ended.
   - If there are any valid events remaining in the heap, attend the one that ends the earliest and remove it from the heap.
5. Count the total number of events attended.

## Data Structures Used

- Array (to store events)
- PriorityQueue (min-heap to keep track of the nearest ending events)

## Intuition

Since we can attend only one event per day, we should always prioritize attending the event that will end the soonest. This way, we leave room to attend more flexible or longer events in the future. The priority queue helps us quickly find the event with the earliest end day.
