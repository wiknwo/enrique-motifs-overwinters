require 'json'

# Class to represent clients in our Custodian department
class Client
  def initialize(name, benefit, cost)
    @name = name
    @benefit = benefit
    @cost = cost
  end

  def cost_benefit_ratio
    @benefit - @cost
  end

  attr_reader :benefit, :name, :cost
end

# Getting user input
budget = gets.to_i

# Creating list of potential clients
potential_clients = [Client.new(1, 11, 3),
                    Client.new(2, 10, 2),
                    Client.new(3, 7, 8),
                    Client.new(4, 5, 1),
                    Client.new(5, 4, 1),
                    Client.new(6, 30, 7),
                    Client.new(7, 15, 4),
                    Client.new(8, 3, 6)]

# Sorting clients
potential_clients.sort_by! {|client| client.cost_benefit_ratio}
total_benefit, i, selected_clients = 0, potential_clients.length - 1, []

# Selecting clients
while (budget > 0) && (i > 0)
  if potential_clients[i].cost <= budget
    selected_clients << potential_clients[i].name
    budget -= potential_clients[i].cost
    total_benefit += potential_clients[i].benefit
  end
  i -= 1
end

# Printing data in JSON format
obj = {:clients => selected_clients, :benefit => total_benefit}
puts JSON.pretty_generate(obj)

# https://stackoverflow.com/questions/17076372/ruby-sort-by-multiple-fields/17076703