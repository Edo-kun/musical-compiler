	# Authors: Vivek Sah, Alex Rinker, Ed Zhou
	# Date: May 2017
	# Compiled From Sources: testfiles/TheHypeSong.bft

	.data
	.globl	gc_flag
gc_flag:
	.word	0

	.text
	li $a0 500
	li $v0 32
	syscall
	b label1
label0:
	li $a2 42
	li $a3 127
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a0 66
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 64
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 61
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 64
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 66
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	jr $ra
label1:
	li $a2 42
	li $a3 127
	li $a1 187
	li $a0 61
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 61
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 73
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 68
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	jal label0
	li $a2 42
	li $a3 127
	li $a1 187
	li $a0 59
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 59
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 73
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 68
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	jal label0
	li $a2 42
	li $a3 127
	li $a1 187
	li $a0 58
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 58
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 73
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 68
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	jal label0
	li $a2 42
	li $a3 127
	li $a1 187
	li $a0 57
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 57
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 73
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 68
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	jal label0
	li $s1 3
label2:
	beq $s1 $zero label3
	sub $s1 $s1 1
	sw $s1 -4($sp)
	li $a1 187
	li $a0 61
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 61
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 73
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 68
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 67
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 66
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 64
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 61
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 64
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 49
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 66
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 59
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 59
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 73
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 68
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 67
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 66
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 64
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 61
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 64
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 66
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 58
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 58
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 73
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 68
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 67
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 66
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 64
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 61
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 64
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 46
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 66
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 57
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 45
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 57
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 73
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 45
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 68
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 45
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 45
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 67
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 66
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 64
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 61
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 64
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 47
	li $a2 44
	li $a3 127
	li $v0 31
	syscall
	li $a0 137
	li $v0 32
	syscall
	li $a1 187
	li $a0 66
	li $a2 42
	li $a3 127
	li $v0 31
	syscall
	li $a1 187
	li $a0 137
	li $v0 32
	syscall
	lw $s1 -4($sp)
	b label2
label3:
