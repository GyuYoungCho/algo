# https://school.programmers.co.kr/learn/courses/30/lessons/60058?language=python3

def solution(p):
	if not p: return p

	ans, isbal, c = "", True, 0
	for i in range(len(p)):
		if p[i] == '(':
			c -= 1
		else:
			c += 1

		if c > 0: isbal = False

		if c == 0:
			if isbal:
				return p[:i + 1] + solution(p[i + 1:])

			else:
				ans = '(' + solution(p[i + 1:]) + ')'
				ans += ''.join(list(map(lambda x: '(' if x == ')' else ')', p[1:i])))
				return ans
