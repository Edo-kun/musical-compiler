	# Authors: Vivek Sah, Alex Rinker, Ed Zhou
	# Date: May 2017
	# Compiled From Sources: testfiles/LegalCode.bft

	.data
	.globl	gc_flag
gc_flag:
	.word	0

	.text
	li $a2 53
	li $a3 127
	li $a1 500
	li $a0 59
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 61
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 63
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 64
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 66
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 68
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 70
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 71
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 400
	li $v0 32
	syscall
	move $a0 $s2
	li $a2 -8
	li $a3 127
	li $a1 571
	li $a0 73
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 471
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 75
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 471
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 76
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 471
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 78
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 471
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 80
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 471
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 82
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 471
	li $v0 32
	syscall
	move $a0 $s2
	li $a0 83
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 471
	li $v0 32
	syscall
	move $a0 $s2
	li $a2 -8
	li $a3 127
	li $a1 4000
	li $a0 59
	li $v0 31
	syscall
	li $a0 63
	li $v0 31
	syscall
	li $a0 66
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 3900
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 4000
	li $a0 59
	li $v0 31
	syscall
	li $a0 63
	li $v0 31
	syscall
	li $a0 66
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 3900
	li $v0 32
	syscall
	move $a0 $s2
	li $a1 4000
	li $a0 59
	li $v0 31
	syscall
	li $a0 63
	li $v0 31
	syscall
	li $a0 66
	li $v0 31
	syscall
	move $s2 $a0
	li $a0 3900
	li $v0 32
	syscall
	move $a0 $s2
