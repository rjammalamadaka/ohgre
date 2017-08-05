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

/**
 * Adobe CQ Mobile Apps module
 *
 * @description
 * This module provides access to the AEM Apps mobile SDK from within an angular application.
 *
 */
(function(angular, cq, undefined) {

    'use strict';

    /**
     * Target Service for interacting with AEM
     * @name cqMobileApps.TargetService
     */
    function TargetService($q, $rootScope) {

        var targetData = null,
            targetMapping = null,
            targeting = false,
            listeners = [
                'target:dataChange'
            ],
            targetQueue = [];

        function _isTargetAvailable() {
            return (cq.mobileapps.targeting.Target !== null);
        }

        function _processTargetQueue() {
            if (targeting) {
                return;
            }

            var self = this;
            var obj = targetQueue.pop();

            if (!obj) {
                return;
            }

            if (!_isTargetAvailable()) {
                obj.deferred.reject("ERROR: Target SDK not found.");
            } else {
                if (!obj.mboxid) {
                    obj.deferred.reject("mbox ID not defined.");
                }

                targeting = true;
                var mboxId = obj.mboxid;

                console.log("Calling target: " + mboxId);

                var target = new cq.mobileapps.targeting.Target(mboxId, obj.element, this.getMapping());

                target.targetLoadRequest(this.getData(), function(error){
                    targeting = false;
                    if (error === null) {
                        obj.deferred.resolve();
                    } else {
                        obj.deferred.reject(error);
                    }
                    _processTargetQueue.call(self);
                });
            }
        }

        return {
            getData: function() {
                return targetData;
            },

            setData: function(data) {
                targetData = data;
                $rootScope.$emit('target:dataChange', data);
            },

            getMapping: function() {
                return targetMapping || {};
            },

            setMapping: function(mapping) {
                targetMapping = mapping;
            },

            available: function () {
                return _isTargetAvailable();
            },

            updateOffer: function(mboxid, element) {
                var deferred = $q.defer();

                targetQueue.push({
                    mboxid:mboxid,
                    element:element,
                    deferred:deferred
                });

                _processTargetQueue.call(this);

                return deferred.promise;
            },

            on: function(event, scope, callback) {
                if(listeners.indexOf(event) === -1) {
                    throw "Unknown event '" + event + "'";
                }
                if(!angular.isFunction(callback)) {
                    throw "Callback must be a function.";
                }
                var handler = $rootScope.$on(event, callback);
                scope.$on('$destroy', handler);
            }
        };
    }

    angular.module('cqMobileApps')
        .factory('TargetService', ['$q', '$rootScope', TargetService]);

})(angular, cq);
