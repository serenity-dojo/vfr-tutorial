Feature: Visual Flight Rules Warnings

  As a private pilot
  I want to be informed if current visibility or cloud cover would violate VFR constraints
  So that I can ensure that I am always flying in minimum conditions for VFR flights


    Scenario Outline: : Flying above FL100 with clouds
      Given the plane is flying at <Flight Level>
      When the current visibility is <Visibility>
      And clouds are reported at:
        | Horizontal distance to clouds   | Vertical distance to clouds   |
        | <Horizontal distance to clouds> | <Vertical distance to clouds> |
      Then the VFT warning should be displayed: <Warning Displayed>

      Examples:
      Flying above FL 100 visibility must be at least 8km, the horizontal distance to clouds must be at least 1500 m
      and the height above clouds must be at least 1000 ft

        | Flight Level | Visibility | Horizontal distance to clouds | Vertical distance to clouds | Warning Displayed | Reason                                   |
        | FL 110       | 10 km      | 2000 m                        | 1200 ft                     | No                | Enough visibility and distance to clouds |
        | FL 110       | 10 km      | 1400 m                        | 1200 ft                     | Yes               | Horizontal distance is lower than 1500 m |
        | FL 110       | 10 km      | 2000 m                        | 800 ft                      | Yes               | Vertical distance is lower that 1000 ft  |
        | FL 110       | 5 km       | 2000 m                        | 1200 ft                     | Yes               | Visibility lower than 8 km               |

      Examples:
      Flying below FL 100 visibility must be at least 5km, the horizontal distance to clouds must be at least 1500 m
      and the height above clouds must be at least 1000 ft
        | Flight Level | Visibility | Horizontal distance to clouds | Vertical distance to clouds | Warning Displayed | Reason                        |
        | FL 90        | 7 km       | 2000 m                        | 1200 ft                     | No                |                               |
#       | FL 90  | 7 km       | 1400 m                        | 1200 ft                     | Yes               | Horizontal distance is lower than 1500m          |
#       | FL 90  | 7 km       | 2000 m                        | 800 ft                      | Yes               | Vertical distance to clouds is lower than 1000ft |
        | FL 90        | 3 km      | 2000 m                        | 1200 ft                     | Yes               | Visibility is lower than 5 km |

#      Scenario Outline: Flying below FL100 with clouds
#        Given the plane is flying at FL 90
#        When the current visibility is <Visibility>
#        And clouds are reported at:
#          | Horizontal distance to clouds | Vertical distance to clouds |
#          | <Distance to clouds>          | <Height below clouds>       |
#        Then the VFT warning should be displayed: <Warning Displayed>
#
#        Examples:
#          | Visibility  | Distance to clouds | Height below clouds | Warning Displayed | Reason                                           |
#          |    7 km     |   2000 m           |   1200 ft           | No                |                                                  |
#          |    7 km     |   1400 m           |   1200 ft           | Yes               | Horizontal distance is lower than 1500m          |
#          |    7 km     |   2000 m           |    800 ft           | Yes               | Vertical distance to clouds is lower than 1000ft |
#          |    3  km    |   2000 m           |   1200 ft           | Yes               | Visibility is lower than 5 km                    |

#       Scenario Outline: Flying close to a flat terrain
#          Given the plane is flying at 2700ft
#          When the speed is <IAS>
#          And the visibility is <Visibility>
#         Then the VFT warning should be displayed: <Warning Displayed>
#
#         Examples:
#           | Visibility | IAS | Warning Displayed | Reason                                 |
#           | 6 KM       | 150 | No                | Visibility is enough for any speed     |
#           | 3 km       | 130 | No                | Speed is below 140knots                |
#           | 3 km       | 150 | Yes               | Speed is higher than 140 knots         |
#           | 1 km       | 130 | Yes               | Visibility is not enough for any speed |
#
#    Scenario Outline: Flying close to a mountainous terrain
#      Given the plane is flying at 4000 ft
#      And the height above terrain is 500 ft
#      When the speed is <IAS>
#      And the visibility is <Visibility>
#      Then the VFT warning should be displayed: <Warning Displayed>
#
#      Examples:
#        | Visibility | IAS | Warning Displayed | Reason                                 |
#        | 6 KM       | 150 | No                | Visibility is enough for any speed     |
#        | 3 km       | 130 | No                | Speed is below 140knots                |
#        | 3 km       | 150 | Yes               | Speed is higher than 140 knots         |
#        | 1 km       | 130 | Yes               | Visibility is not enough for any speed |