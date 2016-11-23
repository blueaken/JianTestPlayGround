singleton with final - must be eager init, other final variable cannot be assign new value afterwards.

- final on methods simply means this method cannot be override. useful for immutable object and some method not want
to be change.
ref: http://stackoverflow.com/questions/5547663/java-final-method-what-does-it-promise

- practice double null check singleton, which is also covered by nine chapter system design class 3

step 1: write a thread safe singleton with final
step 2: break it
1. multi thread cannot break it since it is eager init and with final modifier

2. if the class is Serializable
Solution: can be fixed by override readResolve() method to ensure return the same singleton instance when
deserialization. (writeReplace is not necessary here, the default writeObject should work)

ref:http://stackoverflow.com/questions/2958863/interview-question-about-java-serialization-and-singletons/2958908#2958908

3. if the class is Clonable
Solution: overrride clone() and throw CloneNotSupported exception

4. reflection: a privileged client can invoke the private constructor reflectively with the aid of the
AccessibleObject.setAccessible method.
Solution: modify the constructor to make it throw an exception if it's asked to create a second instance.

5. if multiple class loader loading the class?

Follow up questions:
1. in which scenario we should serialize a singleton?
a: Imagine there is a long-running app and want to be able to shut it down and later continue at the point where it
was shut down (e.g. in order to do hardware maintenance). If the app uses a singleton that is stateful, you'd have
to be able to save and restore the sigleton's state, which is most easily done by serializing it.
(which means singleton can have parameter - state)    ?

2. how to serialization in distributed env?

3. writeexternal and readexternal methods?

4. how to make class immutable?

note:
deep copy and shallow copy of object:
http://javarevisited.blogspot.sg/2014/03/how-to-clone-collection-in-java-deep-copy-vs-shallow.html

Ref:
http://stackoverflow.com/questions/20421920/what-are-the-different-ways-we-can-break-a-singleton-pattern-in-java

http://thecodersbreakfast.net/index.php?post/2011/05/12/Serialization-and-magic-methods


