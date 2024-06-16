;;; Sierra Script 1.0 - (do not remove this comment)
(script# 22)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Feature)
(use Obj)

(public
	TwoGuysFirst 0
)

(local
	local0
	local1
	local2
)
(procedure (localproc_03be param1 param2)
	(param1 setLoop: param2)
)

(procedure (localproc_03c9 param1 param2)
	(proc0_12)
	(= local0 0)
	(param1 setCel: 0 setLoop: param2)
)

(instance TwoGuysFirst of Script
	(properties)
	
	(method (init)
		(Load rsVIEW 212)
		(gAddToPics add: Mark)
		(gAddToPics doit:)
		(Scott init:)
		(MarkHead init:)
		(ScottHead init:)
		(super init: &rest)
	)
	
	(method (doit)
		(if local1 (MarkHead setCel: (Random 0 4)))
		(if local2 (ScottHead setCel: (Random 0 5)))
		(super doit:)
	)
	
	(method (dispose)
		(Scott dispose: delete:)
		(MarkHead dispose: delete:)
		(ScottHead dispose: delete:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(localproc_03be MarkHead 1)
				(= local1 1)
				(= local0 (proc255_0 22 0 67 10 25 70 100 33 600 91))
				(= seconds 12)
			)
			(2
				(= local1 0)
				(localproc_03c9 MarkHead 1)
				(= seconds 4)
			)
			(3
				(localproc_03be ScottHead 3)
				(= local2 1)
				(= local0 (proc255_0 22 1 67 10 25 70 100 33 600 91))
				(= seconds 12)
			)
			(4
				(= local2 0)
				(localproc_03c9 ScottHead 3)
				(= seconds 6)
			)
			(5
				(localproc_03be MarkHead 1)
				(= local1 1)
				(= local0 (proc255_0 22 2 67 10 25 70 100 33 600 91))
				(= seconds 12)
			)
			(6
				(= local1 0)
				(localproc_03c9 MarkHead 1)
				(if (> global175 15) (= global175 15))
				(global2 setScript: 0)
			)
		)
	)
)

(instance Mark of PV
	(properties
		y 109
		x 34
		view 212
		priority 15
		signal $4000
	)
)

(instance Scott of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 0
			setCel: 1
			posn: 70 101
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)

(instance MarkHead of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 1
			setCel: 0
			posn: 36 109
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)

(instance ScottHead of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 3
			setCel: 0
			posn: 72 102
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)
