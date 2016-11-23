again, the requirement is vague on whether to deal with overflow or not. I submitted the solution of dealing with overflow with
the previous mathematic way. It works as expected but not what the question is asked.I rewrote another solution dealing with digits only.

- note: have to create a new list since Arrays.asList returns a fixed size list by definition. For interview question, this may not be well
  designed.

- note: slightly strange here comparing to directly insert 1 to the front of list on line 40. The consideration is the list is implemented
        as an ArrayList, appending an element is far more efficient than inserting to the front, because all elements have to be shifted
        one place to the right otherwise.
