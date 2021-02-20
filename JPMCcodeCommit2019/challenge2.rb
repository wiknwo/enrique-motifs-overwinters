require 'json'

# Getting user input
balance = gets.to_i
tradingOrder = gets.chomp.split(/[ ,=]/)

# Performing trading order rules on tokens
buy_ops, sell_ops, hold_ops, time, error_at, = 0, 0, 0, 0, -1
tradingOrder.length.times do |i|
  if tradingOrder[i].casecmp("HOLD").zero?
    hold_ops += 1
    time += 10

  elsif tradingOrder[i].casecmp("BUY").zero?
    buy_ops += 1
    time += 10
    # Missing or negative value
    if tradingOrder[i + 1].eql?("") || tradingOrder[i + 1].start_with?("-")
      error_at = i
      break

    # Decrease balance by BUY amount
    else
      balance -= tradingOrder[i + 1].to_i
      if balance.negative?
        error_at = i
        break
      end
    end

  elsif tradingOrder[i].casecmp("SELL").zero?
    sell_ops += 1
    time += 10
    # Missing or negative value
    if tradingOrder[i + 1].eql?("") || tradingOrder[i + 1].start_with?("-")
      error_at = i
      break

    else balance += tradingOrder[i + 1].to_i
    end
  end
end

# Creating and printing json object
obj = {:balance => balance,
       :time => time,
       :buy_ops => buy_ops,
       :sell_ops => sell_ops,
       :hold_ops => hold_ops}

if error_at != -1 then obj["error_at"] = error_at end
puts JSON.pretty_generate(obj)

# https://stackoverflow.com/questions/6002839/initialize-two-variables-on-same-line
# https://stackoverflow.com/questions/19509307/split-string-by-multiple-delimiters/19509391