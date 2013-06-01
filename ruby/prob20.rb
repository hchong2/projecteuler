a=1
for i in 1..100
  a = a*i
end

x = a.to_s.split('')
y=0

x.each{ |x|  y=y+x.to_i}
puts 'Answer: ' + y.to_s

