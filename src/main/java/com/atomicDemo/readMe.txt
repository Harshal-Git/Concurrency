A demo to show 3 cases:

1. Normal operations between 2 threads for a shared member will create unexpected results.

2. If that normal operation is "synchronized"; it will add it's own time consumption of switching contexts & waiting time. But it
	will provide expected results.

3. Instead of going ahead with synchronization; expected results can be obtained with Atomic APIs; which will remove waiting 
	time & context switching of synchronization.   