/*
 *  Copyright 2016 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
(function(angular, undefined) {
    'use strict';

    /**
     * Targeting Directive
     *
     * @name mobileapps.directive:cqTargeting
     *
     * @requires mobileapps.TargetService
     *
     * @restrict A
     *
     * @description
     *
     */
    function TargetingDirective($ionicLoading, TargetService) {

        return {
            restrict: 'A',
            scope: {
                mboxId: '@mboxid'
            },
            link: function(scope, element, attr) {

                document.removeEventListener('deviceready', doTarget );
                document.addEventListener('deviceready', doTarget, false );

                TargetService.on("target:dataChange", scope, doTarget);

                function doTarget() {
                    if (TargetService.available()) {
                        $ionicLoading.show({
                            hideOnStateChange: true
                        });
                        TargetService.updateOffer(scope.mboxId, element[0])
                            .then(function() {
                                console.log("Offer updated");
                            }, function() {
                                console.log("Offer not updated");
                            })
                            .finally(function() {
                                $ionicLoading.hide();
                            });
                    }
                }

            }
        };
    }

    angular.module('cqMobileApps')
        .directive('cqTargeting', ['$ionicLoading', 'TargetService', TargetingDirective]);

})(angular);