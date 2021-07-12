# Concurrency
java.util.concurrent package, concurrent data structures & other Concurrency related concepts

introduced since java 1.5 version.

###
Some problems with "synchronized" keyword which is expected to be solved by java.util.concurrent.lock package:

1. If thread cannot obtain / release a lock on time; deadlock may occur. 
solution : in place lock methods to check in advance whether lock can be acquired on given object OR not.

2. When multiple threads are waiting to acquire a lock; no guarantee which thread will receive it. It completely depends on JVM.
solution : A fairness policy is present with concurrency so that longest waiting thread will get first lock. This policy can be 
		enabled / disabled. 

3. No API to know at a time how many threads are in waiting state?

4. In traditional approach; there is no way to choose alternate option if thread is not able to acquire a lock on an object. And 
	there is no limit of maximum amount of time a thread can wait to acquire lock.
	
5. 'synchronized' is applicable at method level OR for a small block within a single method; but not applicable across multiple 
	methods.

###

Lock a thread acquires while using 'synchronized' keyword - implicit lock 

Lock interface : to acquire lock on objects explicitly, which is similar to implicit lock
	-> ReentrantLock
	-> ReadLock / ReadLockView ?
	-> WriteLock / WriteLockView ?
	