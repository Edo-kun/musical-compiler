	# Authors: Vivek Sah, Alex Rinker, Ed Zhou
	# Date: May 2017
	# Compiled From Sources: testfiles/BlockDemo.bft

	.data
	.globl	gc_flag
gc_flag:
	.word	0

	.text
	li $a1 500
	li $a0 59
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	li $a1 444
	li $a0 47
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 344
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 444
	li $a0 47
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 -44
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 61
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 288
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 444
	li $a0 49
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 12
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 63
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 232
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 444
	li $a0 51
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 68
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 64
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 176
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 444
	li $a0 52
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 124
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 66
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 120
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 444
	li $a0 54
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 180
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 68
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 64
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 444
	li $a0 56
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 236
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 70
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 8
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 444
	li $a0 58
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 292
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 71
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 -48
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 444
	li $a0 59
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 344
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 73
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	li $a1 500
	li $a0 61
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 75
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	li $a1 500
	li $a0 63
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 76
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	li $a1 500
	li $a0 64
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 78
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	li $a1 500
	li $a0 66
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 80
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	li $a1 500
	li $a0 68
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 82
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	li $a1 500
	li $a0 70
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a0 83
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	li $a1 500
	li $a0 71
	li $a2 53
	li $a3 127
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
	li $a1 500
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 500
