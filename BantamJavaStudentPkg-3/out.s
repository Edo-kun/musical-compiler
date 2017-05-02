	# Authors: Vivek Sah, Alex Rinker, Ed Zhou
	# Date: May 2017
	# Compiled From Sources: testfiles/LegalCode.bft

	.data
	.globl	gc_flag
gc_flag:
	.word	0

	.text
	li $s1 3
label0:
	beq $s1 $zero label1
	sub $s1 $s1 1
	sw $s1 -4($sp)
	li $a2 53
	li $a3 127
	li $a1 462
	li $a0 59
	li $v0 33
	syscall
	li $a0 61
	li $v0 33
	syscall
	li $a0 63
	li $v0 33
	syscall
	li $a0 64
	li $v0 33
	syscall
	li $a0 66
	li $v0 33
	syscall
	li $a0 68
	li $v0 33
	syscall
	li $a0 70
	li $v0 33
	syscall
	li $a0 71
	li $v0 33
	syscall
	li $a2 -8
	li $a3 127
	li $a1 528
	li $a0 73
	li $v0 33
	syscall
	li $a0 75
	li $v0 33
	syscall
	li $a0 76
	li $v0 33
	syscall
	li $a0 78
	li $v0 33
	syscall
	li $a0 80
	li $v0 33
	syscall
	li $a0 82
	li $v0 33
	syscall
	li $a0 83
	li $v0 33
	syscall
	lw $s1 -4($sp)
	b label0
label1:
